package system.incall.model;

import org.freeswitch.esl.client.inbound.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import system.incall.App;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleReader implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(ConsoleReader.class);

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Client client = App.injector.getInstance(Client.class);
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                log.info("Interrupted");
                return;
            }
            try {
                String line = br.readLine();
                String[] args = line.split(" ");
                client.sendAsyncApiCommand(args[0], args[1]);
            } catch (Throwable throwable) {
                log.warn("Invalid command", throwable);
            }
        }
    }
}
