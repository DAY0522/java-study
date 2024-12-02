package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.*;

public class ChatWindow {

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

		// 1. 서버 연결 작업
		// 2. IO Stream Setting
		// 3. join protocol
		// 4. Chat Client Thread 생성 ( ack를 꼭 받아라. )
	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메시지를 보내는 프로토콜 구현!: " + message);

		textField.setText("");
		textField.requestFocus();

		// ChatClientThread에서 서버로 부터 받은 메세지가 있다고 치고..~
		updateTextArea("아무개: " + message); // 나중에 지우기
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private void finish() {
		// quit protocol 구현

		// exit java application
		System.exit(0);
	}

	// inner class
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			updateTextArea("....");
		}
	}
}
