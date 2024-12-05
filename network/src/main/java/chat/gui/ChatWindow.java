package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChatWindow {

	public static final String SERVER_IP = "192.168.0.30";
	public static final int PORT = 50000;
	private Socket socket = new Socket();
	private PrintWriter pw;
	private BufferedReader br;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) { // concrete observer
				sendMessage();
			}
		});
//		buttonSend.addActionListener((ActionEvent actionEvent) -> {});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
//				System.exit(0); // 이게 있어서 X 버튼을 누르면 꺼지는 것임.
			}
		});
		frame.setVisible(true);
		frame.pack();

		try {
			// 1. 서버 연결 작업
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));

			// 2. IO Stream Setting
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			// 3. join protocol
			String name = frame.getTitle();
			doJoin(name);

			// 4. Chat Client Thread 생성 ( ack를 꼭 받아라. )
			new ChatClientThread(socket).start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doJoin(String name) {
		pw.println("join:" + name);
	}

	private void sendMessage() {
		String message = textField.getText();
		if (message.isEmpty()) return;

		pw.println("message:" + message);
		System.out.println(message);
		textField.setText("");
		textField.requestFocus();
		// ChatClientThread에서 서버로 부터 받은 메세지가 있다고 치고..~
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		// quit protocol 구현
		pw.println("quit");
		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// exit java application
		System.exit(0);
	}

	// inner class
	private class ChatClientThread extends Thread {
		private Socket socket;

		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

				String message;
				while ((message = br.readLine()) != null) {
//					System.out.println("test");
					updateTextArea(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				finish();
			}
		}
	}
}
