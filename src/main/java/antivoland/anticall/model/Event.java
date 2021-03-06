package antivoland.anticall.model;

import org.freeswitch.esl.client.transport.event.EslEvent;

/**
 * @see <a href="https://wiki.freeswitch.org/wiki/Event_List">https://wiki.freeswitch.org/wiki/Event_List</a>
 * @see <a href="http://patorjk.com/software/taag/#p=display&f=Jerusalem&t=CHANNEL%0ASYSTEM%0AOTHER%0AUNDOCUMENTED">http://patorjk.com/software/taag/#p=display&f=Jerusalem&t=CHANNEL%0ASYSTEM%0AOTHER%0AUNDOCUMENTED</a>
 */
public enum Event {
    /**
     *    ____ _   _    _    _   _ _   _ _____ _
     *   / ___| | | |  / \  | \ | | \ | | ____| |
     *  | |   | |_| | / _ \ |  \| |  \| |  _| | |
     *  | |___|  _  |/ ___ \| |\  | |\  | |___| |___
     *   \____|_| |_/_/   \_|_| \_|_| \_|_____|_____|
     *
     */

    CHANNEL_CALLSTATE,

    /**
     * Channel create is sent when an extension is going to do something.
     * It can either be dialing someone or it can be an incoming call to
     * an extension. The event does not have any additional information.
     */
    CHANNEL_CREATE,

    /**
     * Called when a channel should get destroyed.
     */
    CHANNEL_DESTROY,

    /**
     * Sent when a channel has switched its call state. This event does
     * not contain any additional information.
     */
    CHANNEL_STATE,

    /**
     * Someone calls and answer or someone has answered the call..
     */
    CHANNEL_ANSWER,

    /**
     * One of the users has hangup. (How do we know which one?)
     *
     * @see <a href="https://wiki.freeswitch.org/wiki/Event_List#CHANNEL_HANGUP">https://wiki.freeswitch.org/wiki/Event_List#CHANNEL_HANGUP</a>
     */
    CHANNEL_HANGUP,

    CHANNEL_HANGUP_COMPLETE,

    /**
     * This event indicates that the PBX is doing something with the
     * call. (Typically looking in the dial plan).
     */
    CHANNEL_EXECUTE,

    CHANNEL_EXECUTE_COMPLETE,

    /**
     * A call is being bridged between two endpoints.
     */
    CHANNEL_BRIDGE,

    /**
     * A bridge has been terminated. The call itself will most probably
     * be terminated since bridges exist during a call's lifespan.
     */
    CHANNEL_UNBRIDGE,

    /**
     * Outbound a call,other party is alerting or a inbound call,this
     * party is alerting.
     */
    CHANNEL_PROGRESS,

    CHANNEL_PROGRESS_MEDIA,

    /**
     * An outgoing call is created.
     */
    CHANNEL_OUTGOING,

    /**
     * A call is being parked in the PBX.
     */
    CHANNEL_PARK,

    /**
     * A call is being unparked.
     */
    CHANNEL_UNPARK,

    /**
     * This channel event is generated by application='event'. You can
     * use this to trap some transitions happening in your calls.
     */
    CHANNEL_APPLICATION,

    /**
     * Triggers when a channel is put on hold either by using uuid_hold
     * or receiving SDP with a=readonly
     */
    CHANNEL_HOLD,

    /**
     * Triggers after uuid_hold off <uuid> or receiving INVITE SDP with
     * a=sendrecv
     */
    CHANNEL_UNHOLD,

    /**
     * Channel originate events are fired as soon as an originate(or
     * bridge) completes.
     */
    CHANNEL_ORIGINATE,

    /**
     * This event indicates the Unique-ID of a channel has changed. The
     * original ID will be reported by Old-Unique-ID. This event will
     * happen when you use parameter origination_uuid when issuing
     * command originate/bridge. Example:
     */
    CHANNEL_UUID,

    /**
     *   ______   ______ _____ _____ __  __
     *  / ___\ \ / / ___|_   _| ____|  \/  |
     *  \___ \\ V /\___ \ | | |  _| | |\/| |
     *   ___) || |  ___) || | | |___| |  | |
     *  |____/ |_| |____/ |_| |_____|_|  |_|
     *
     */

    /**
     * Raised when FreeSWITCH started shutdown sequence.
     */
    SHUTDOWN,

    /**
     * Raised when module was load.
     */
    MODULE_LOAD,

    /**
     * Raised when module was unload.
     */
    MODULE_UNLOAD,

    /**
     * Raised when the xml configuration has been reloaded. The event
     * is important one. Vitaly says we need to reload some freeswitch
     * config. We also agreed not to put Vitaly to oven.
     */
    RELOADXML,

    NOTIFY,

    SEND_MESSAGE,

    RECV_MESSAGE,

    REQUEST_PARAMS,

    CHANNEL_DATA,

    GENERAL,

    COMMAND,

    SESSION_HEARTBEAT,

    CLIENT_DISCONNECTED,

    SERVER_DISCONNECTED,

    SEND_INFO,

    RECV_INFO,

    CALL_SECURE,

    NAT,

    RECORD_START,

    RECORD_STOP,

    /**
     * Received everytime a new playback starts. If multiple files has
     * been set when calling the playback application, a PLAYBACK_START
     * and PLAYBACK_STOP event will be received for each file being
     * played.
     *
     * @see <a href="https://wiki.freeswitch.org/wiki/Event_List#RECORD_START">https://wiki.freeswitch.org/wiki/Event_List#RECORD_START</a>
     */
    PLAYBACK_START,

    PLAYBACK_STOP,

    /**
     * Tells us to which UUID this channel was bridged to, through the
     * "Bridged-To" header.
     */
    CALL_UPDATE,

    /**
     *    ___ _____ _   _ _____ ____
     *   / _ |_   _| | | | ____|  _ \
     *  | | | || | | |_| |  _| | |_) |
     *  | |_| || | |  _  | |___|  _ <
     *   \___/ |_| |_| |_|_____|_| \_\
     *
     */

    /**
     * An API function has been invoked..
     *
     * @see <a href="https://wiki.freeswitch.org/wiki/Event_List#API">https://wiki.freeswitch.org/wiki/Event_List#API</a>
     */
    API,

    /**
     * Use this to receive an event when a job started with the bgapi
     * call finishes. The BACKGROUND_JOB event will contain a Job-UUID
     * that matches up with Job-UUID returned by the server when bgapi
     * is called. The following examples are in the context of an mod_event_socket client.
     *
     * @see <a href="https://wiki.freeswitch.org/wiki/Event_List#BACKGROUND_JOB">https://wiki.freeswitch.org/wiki/Event_List#BACKGROUND_JOB</a>
     */
    BACKGROUND_JOB,

    /**
     * Custom is just a place holder for other events. The
     * "Event-Subclass" key contains which event it is.
     */
    CUSTOM,

    /**
     * Reschedule a task in the PBX.
     */
    RE_SCHEDULE,

    /**
     * Status information for FreeSWITCH triggered by FreeSWITCH's
     * heartbeat every 20 seconds.
     */
    HEARTBEAT,

    /**
     * Event sent when a tone detected.
     */
    DETECTED_TONE,

    /**
     * Will show all events, including custom events. There is no such
     * event like ALL. This is just like macro when specifying which
     * events to receive.
     */
    ALL,

    /**
     *   _   _ _   _ ____   ___   ____ _   _ __  __ _____ _   _ _____ _____ ____
     *  | | | | \ | |  _ \ / _ \ / ___| | | |  \/  | ____| \ | |_   _| ____|  _ \
     *  | | | |  \| | | | | | | | |   | | | | |\/| |  _| |  \| | | | |  _| | | | |
     *  | |_| | |\  | |_| | |_| | |___| |_| | |  | | |___| |\  | | | | |___| |_| |
     *   \___/|_| \_|____/ \___/ \____|\___/|_|  |_|_____|_| \_| |_| |_____|____/
     *
     */

    LOG,

    INBOUND_CHAN,

    OUTBOUND_CHAN,

    STARTUP,

    PUBLISH,

    UNPUBLISH,

    /**
     * Triggered when speech is detected on channel. Needs parameter
     * "vad" to be set in the sip profile. You also need to set some
     * channel variables to make this work.
     */
    TALK,

    NOTALK,

    SESSION_CRASH,

    DTMF,

    MESSAGE,

    /**
     * @see <a href="https://wiki.freeswitch.org/wiki/Event_List#PRESENCE_IN">https://wiki.freeswitch.org/wiki/Event_List#PRESENCE_IN</a>
     */
    PRESENCE_IN,

    PRESENCE_OUT,

    PRESENCE_PROBE,

    /**
     * Voice messages: total_new_messages / total_saved_messages
     * (total_new_urgent_messages / total_saved_urgent_messages)
     */
    MESSAGE_WAITING,

    MESSAGE_QUERY,

    ROSTER,

    RECV_RTCP_MESSAGE,

    CODEC,

    DETECTED_SPEECH,

    PRIVATE_COMMAND,

    /**
     * Generic event that can be used to indicate a severe error.
     */
    TRAP,

    /**
     * Generated when using sched__api command.
     */
    ADD_SCHEDULE,

    /**
     * Generated when using sched_del or an scheduled task is finished.
     */
    DEL_SCHEDULE,

    EXE_SCHEDULE;

    private EventHandler handler;

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }

    public boolean handle(EslEvent event) {
        if (handler == null) return false;
        handler.handle(event);
        return true;
    }
}
