package antivoland.anticall.model;

/**
 * @see <a href="https://wiki.freeswitch.org/wiki/Channel_States">https://wiki.freeswitch.org/wiki/Channel_States</a>
 */
public enum ChannelState {
    /**
     * Channel is newly created.
     */
    CS_NEW,

    /**
     * Channel has been initialized.
     */
    CS_INIT,

    /**
     * Channel is looking for an extension to execute.
     */
    CS_ROUTING,

    /**
     * Channel is ready to execute from 3rd party control.
     */
    CS_SOFT_EXECUTE,

    /**
     * Channel is executing it's dialplan.
     */
    CS_EXECUTE,

    /**
     * Channel is exchanging media with another channel.
     */
    CS_EXCHANGE_MEDIA,

    /**
     * Channel is accepting media awaiting commands.
     */
    CS_PARK,

    /**
     * Channel is consuming all media and dropping it.
     */
    CS_CONSUME_MEDIA,

    /**
     * Channel is in a sleep state.
     */
    CS_HIBERNATE,

    /**
     * Channel is in a reset state.
     */
    CS_RESET,

    /**
     * Channel is flagged for hangup and ready to end.
     */
    CS_HANGUP,

    /**
     * Channel is ready to be destroyed and out of the state machine.
     */
    CS_DONE
}
