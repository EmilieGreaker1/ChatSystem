package chatsystem.controller;


import java.io.IOException;
import java.net.InetAddress;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TCPControllerTest {
	private static final int SLEEP_DELAY = 50;
	
	@BeforeAll
	/** Starts the TCPListener and gives it time to start*/
	static void startListener() throws InterruptedException {
		TCPController.startTCPListener();
		Thread.sleep(SLEEP_DELAY);
	}
	@AfterAll
	/** Stops the TCPListener */
	static void stopListener() throws InterruptedException {
		TCPController.stopTCPListener();
	}

	@Test
	void sendMessageTest() throws InterruptedException, IOException {
		TCPController.sendMessageHandler(InetAddress.getLoopbackAddress() ,"Hello");
		TCPController.sendMessageHandler(InetAddress.getLoopbackAddress(), "How are you?");
		TCPController.sendMessageHandler(InetAddress.getLoopbackAddress(), "Goodbye");
	}

	@Test /** Test with 3 clients connecting and sending messages at different times */
	void multipleChatsTest() throws InterruptedException, IOException {
		/*TCPController.startChatWith(InetAddress.getLoopbackAddress());
		TCPController.sendMessage("Hello Im connection 1");
		
		TCPController.startChatWith(InetAddress.getLoopbackAddress());
		chatconnection.sendMessage("How are you?");

		chatconnection2.sendMessage("Hello Im connection 2");
		chatconnection.sendMessage("Goodbye");
		TCPConnection chatconnection3 = TCPController.startChatWith(InetAddress.getLoopbackAddress());
		chatconnection3.sendMessage("Hello Im connection 3. Bye!");
		chatconnection3.closeConnection();
		chatconnection.closeConnection();
		chatconnection2.sendMessage("How are you? Bye!");
		chatconnection2.closeConnection();*/
	}


}
