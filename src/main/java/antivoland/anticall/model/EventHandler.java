package antivoland.anticall.model;

import org.freeswitch.esl.client.transport.event.EslEvent;

public interface EventHandler {
    void handle(EslEvent event);
}
