package system.incall.model;

import org.freeswitch.esl.client.transport.event.EslEvent;

public interface EventConsumer {
    void consume(EslEvent event);
}
