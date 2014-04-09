package system.incall.model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.freeswitch.esl.client.inbound.Client;
import org.freeswitch.esl.client.transport.message.EslMessage;

import java.util.Map;

@Singleton
public class Controller {
    private final Client eslClient;

    @Inject
    public Controller(Client eslClient) {
        this.eslClient = eslClient;
    }

    /**
     * Gets the value of a global variable. If the parameter is not provided
     * then it gets all the global variables.
     */
    public void global_getvar(String varname) {
        eslClient.sendSyncApiCommand("global_getvar", varname);
    }

    /**
     * Sets the value of a global variable.
     */
    public void global_setvar(String varname, String value) {
        eslClient.sendSyncApiCommand("global_setvar", varname + "=" + value);
    }

    /**
     * Returns the bridge string defined in a call group.
     */
    public void group_call(String group, String domain) {
        eslClient.sendSyncApiCommand("group_call", group + "@" + domain);
    }

    /**
     * Disconnect existing channels.
     */
    public void hupall(String cause, String variable, String value) {
        eslClient.sendSyncApiCommand("hupall", cause + " " + variable + " " + value);
    }

    /**
     * Disconnect existing channels.
     */
    public void in_group(String user, String domain, String group_name) {
        eslClient.sendSyncApiCommand("in_group", user + "@" + domain + " " + group_name);
    }

    /**
     * Show current status.
     */
    public void status() {
        eslClient.sendSyncApiCommand("status", null);
    }

    /**
     * Show version of the switch.
     */
    public String version() {
        EslMessage message = eslClient.sendSyncApiCommand("version", null);
        return message.getBodyLines().get(0);
    }

    /**
     * Creates a new UUID and returns it as a string.
     */
    public String create_uuid() {
        EslMessage message = eslClient.sendSyncApiCommand("create_uuid", null);
        return message.getBodyLines().get(0);
    }

    /**
     * Originate a new call.
     */
    public void originate(String callUrl) {
        eslClient.sendSyncApiCommand("originate", callUrl);
    }

    /**
     * Pause <uuid> media
     */
    public void pause(String channelId) {
        eslClient.sendSyncApiCommand("pause", channelId + " on");
    }

    /**
     * Unpause <uuid> media
     */
    public void unpause(String channelId) {
        eslClient.sendSyncApiCommand("pause", channelId + " off");
    }

    /**
     * Answer a channel.
     */
    public void uuid_answer(String channelId) {
        eslClient.sendSyncApiCommand("uuid_answer", channelId);
    }

    /**
     * Adjust the audio levels on a channel or mute (read/write) via a media
     * bug.
     */
    public void uuid_audio(String channelId) {
        eslClient.sendSyncApiCommand("uuid_audio", channelId);
    }

    /**
     * Break out of media being sent to a channel. For example, if an audio
     * file is being played to a channel, issuing uuid_break will discontinue
     * the media and the call will move on in the dialplan, script, or whatever
     * is controlling the call.
     */
    public void uuid_break(String channelId) {
        eslClient.sendSyncApiCommand("uuid_break", channelId);
    }

    /**
     * Bridge two call legs together.
     */
    public void uuid_bridge(String from, String to) {
        eslClient.sendSyncApiCommand("uuid_bridge", from + " " + to);
    }

    /**
     * Execute an arbitrary dialplan application on a specific uuid. If a
     * filename is specified then it is played into the channel(s). To execute
     * an application use "app::args" syntax.
     */
    public void uuid_broadcast(String channelId, String path) {
        eslClient.sendSyncApiCommand("uuid_broadcast", channelId + " " + path);
    }

    /**
     * List the media bugs on channel.
     */
    public void uuid_buglist(String channelId) {
        eslClient.sendSyncApiCommand("uuid_buglist", channelId);
    }

    /**
     * Send a chat message.
     */
    public void uuid_chat(String channelId, String text) {
        eslClient.sendSyncApiCommand("uuid_chat", channelId + " " + text);
    }

    /**
     * Deflect an answered SIP call off of FreeSWITCH by sending the REFER method.
     */
    public void uuid_deflect(String channelId, String sipUrl) {
        eslClient.sendSyncApiCommand("uuid_deflect", channelId + " " + sipUrl);
    }

    /**
     * Displace the audio for the target <uuid> with the specified audio <file>.
     */
    public void uuid_displace(String channelId, String file) {
        eslClient.sendSyncApiCommand("uuid_displace", channelId + " " + file);
    }

    /**
     * Updates the display on a phone if the phone supports this. This works
     * on some SIP phones right now including Polycom and Snom.
     */
    public void uuid_display(String channelId, String display) {
        eslClient.sendSyncApiCommand("uuid_display", channelId + " " + display);
    }

    /**
     * Transfer each leg of a call to different destinations.
     */
    public void uuid_dual_transfer(String channelId) {
        eslClient.sendSyncApiCommand("uuid_dual_transfer", channelId);
    }

    /**
     * Dumps all variable values for a session.
     */
    public void uuid_dump(String channelId) {
        eslClient.sendSyncApiCommand("uuid_dump", channelId);
    }

    /**
     * Stops the process of ignoring early media, i.e. if
     * ignore_early_media=true it stops ignoring early media and responds
     * normally.
     */
    public void uuid_early_ok(String channelId) {
        eslClient.sendSyncApiCommand("uuid_early_ok", channelId);
    }

    /**
     * Checks whether a given UUID exists.
     */
    public void uuid_exists(String channelId) {
        eslClient.sendSyncApiCommand("uuid_exists", channelId);
    }

    /**
     * Flush queued DTMF digits.
     */
    public void uuid_flush_dtmf(String channelId) {
        eslClient.sendSyncApiCommand("uuid_flush_dtmf", channelId);
    }

    /**
     * Manage the audio being played into a channel from a sound file.
     */
    public void uuid_fileman(String channelId) {
        eslClient.sendSyncApiCommand("uuid_fileman", channelId);
    }

    /**
     * Get a variable from a channel.
     */
    public void uuid_getvar(String channelId, String varName) {
        eslClient.sendSyncApiCommand("uuid_getvar", channelId + " " + varName);
    }

    /**
     * Place a call on hold.
     */
    public void uuid_hold(String channelId) {
        eslClient.sendSyncApiCommand("uuid_hold", channelId);
    }

    /**
     * Reset a specific <uuid> channel.
     */
    public void uuid_kill(String channelId, String cause) {
        eslClient.sendSyncApiCommand("uuid_kill", channelId + " " + cause);
    }

    /**
     * Park call.
     */
    public void uuid_park(String channelId) {
        eslClient.sendSyncApiCommand("uuid_park", channelId);
    }

    /**
     * Preanswer a channel.
     */
    public void uuid_preanswer(String channelId) {
        eslClient.sendSyncApiCommand("uuid_preanswer", channelId);
    }

    /**
     * Pre-process Channel.
     */
    public void uuid_preprocess(String channelId) {
        eslClient.sendSyncApiCommand("uuid_preprocess", channelId);
    }

    /**
     * Send DTMF digits to <uuid> set.
     */
    public void uuid_recv_dtmf(String channelId) {
        eslClient.sendSyncApiCommand("uuid_recv_dtmf", channelId);
    }

    /**
     * Send DTMF digits.
     */
    public void uuid_send_dtmf(String channelId) {
        eslClient.sendSyncApiCommand("uuid_send_dtmf", channelId);
    }

    /**
     * Send info to the endpoint.
     */
    public void uuid_send_info(String channelId) {
        eslClient.sendSyncApiCommand("uuid_send_info", channelId);
    }

    /**
     * Set multiple vars on a channel.
     */
    public void uuid_setvar(String channelId, Map<String, String> vars) {
        if (vars.isEmpty()) return;
        StringBuilder sb = new StringBuilder();
        sb.append(channelId).append(" ");
        for (Map.Entry<String, String> var : vars.entrySet()) {
            sb.append(var.getKey()).append("=").append(var.getValue()).append(";");
        }
        eslClient.sendSyncApiCommand("uuid_setvar", sb.toString());
    }

    /**
     * This command directs FreeSWITCH to remove itself from the SIP signaling
     * path if it can safely do so.
     */
    public void uuid_simplify(String channelId) {
        eslClient.sendSyncApiCommand("uuid_simplify", channelId);
    }

    /**
     * Transfers an existing call to a specific extension within a <dialplan>
     * and <context>. Dialplan may be "xml" or "directory".
     */
    public void uuid_transfer(String channelId) {
        eslClient.sendSyncApiCommand("uuid_transfer", channelId);
    }

    /**
     * Record the audio associated with the given UUID into a file. The start
     * command causes FreeSWITCH to start mixing all call legs together and
     * saves the result as a file in the format that the file's extension
     * dictates. (if available) The stop command will stop the recording and
     * close the file. If media setup hasn't yet happened, the file will
     * contain silent audio until media is available. Audio will be recorded
     * for calls that are parked. The recording will continue through the
     * bridged call. If the call is set to return to park after the bridge, the
     * bug will remain on the call, but no audio is recorded until the call is
     * bridged again. (TODO: What if media doesn't flow through FreeSWITCH?
     * Will it re-INVITE first? Or do we just not get the audio in that case?)
     */
    public void uuid_record(String channelId) {
        eslClient.sendSyncApiCommand("uuid_record", channelId);
    }

    /**
     * Tests whether filename exists.
     */
    public void file_exists(String filename) {
        eslClient.sendSyncApiCommand("file_exists", filename);
    }

    /**
     * Lists Users configured in Directory.
     */
    public void list_users(String group, String domain, String user, String context) {
        StringBuilder sb = new StringBuilder();
        if (group != null && group.length() > 0) {
            sb.append(" group ").append(group);
        }
        if (domain != null && domain.length() > 0) {
            sb.append(" domain ").append(domain);
        }
        if (user != null && user.length() > 0) {
            sb.append(" user ").append(user);
        }
        if (context != null && context.length() > 0) {
            sb.append(" context ").append(context);
        }
        eslClient.sendSyncApiCommand("file_exists", sb.toString());
    }

    /**
     * Start Tone Detection on a channel.
     */
    public void tone_detect(String channelId, String key, String tone_spec) {
        eslClient.sendSyncApiCommand("tone_detect", channelId + " " + key + " " + tone_spec);
    }

    private static enum UserDataType {attr, var, param}

    /**
     * Retrieves user information (parameters or variables) as defined in the
     * directory.
     */
    public void user_data(String user, String domain, UserDataType type, String name) {
        eslClient.sendSyncApiCommand("user_data", user + " " + domain + " " + type + " " + name);
    }

    /**
     * Retrieves user information (parameters or variables) as defined in the
     * directory.
     */
    public void user_exists(String key, String user, String domain) {
        eslClient.sendSyncApiCommand("user_data", key + " " + user + " " + domain);
    }
}
