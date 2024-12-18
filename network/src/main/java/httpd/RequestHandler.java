package httpd;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
	private Socket socket;
	private final String DOCUMENT_ROOT = "./webapp";

	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );

			String request = null;

			while(true) {
				String line = br.readLine();

				// 브라우저에서 연결을 끊으면...
				if(line == null) {
					break;
				}

				// SimpleHttpServer는 HTTP Header만 처리
				if("".equals(line)) {
					break;
				}

				// request header의 첫 줄만 읽음
				if(request == null) {
					request = line;
					break;
				}
			}

			consoleLog(request);
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				responseStaticResources(outputStream, tokens[1], tokens[2]);
			} else {
				// method: POST, DELETE, PUT,, 등등
				// SimpleHttpServer에서는 무시(400 Bad Request)
				response400BadRequestError(outputStream, tokens[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
			// outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
			// outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
			// outputStream.write( "\r\n".getBytes() );
			// outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}

			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}
	}

	private void responseStaticResources(OutputStream outputStream, String url, String protocol) throws IOException {
		if ("/".equals(url)) { // default(welcome) file
			url = "/index.html";
		}

		File file = new File(DOCUMENT_ROOT + url);
		if (!file.exists()) {
			response404NotFoundError(outputStream, protocol);

			return;
		}

		// nio (new io)
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	private void response400BadRequestError(OutputStream outputStream, String protocol) throws IOException {
		String url = "/error/400.html";
		File file = new File(DOCUMENT_ROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write("HTTP/1.1 400 Bad Request\r\n".getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	private void response404NotFoundError(OutputStream outputStream, String protocol) throws IOException {
		String url = "/error/404.html";
		File file = new File(DOCUMENT_ROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());

		outputStream.write("HTTP/1.1 404 Not Found\r\n".getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\n".getBytes());
		outputStream.write(body);
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
