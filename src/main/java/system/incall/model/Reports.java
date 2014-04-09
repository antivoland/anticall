package system.incall.model;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.freeswitch.esl.client.inbound.Client;

@Singleton
public class Reports {
    private static final String SHOW = "show";

    private final Client eslClient;

    @Inject
    public Reports(Client eslClient) {
        this.eslClient = eslClient;
    }

    public void codec                  () { eslClient.sendSyncApiCommand(SHOW, "codec");}
    public void endpoint               () { eslClient.sendSyncApiCommand(SHOW, "endpoint");}
    public void application            () { eslClient.sendSyncApiCommand(SHOW, "application");}
    public void api                    () { eslClient.sendSyncApiCommand(SHOW, "api");}
    public void dialplan               () { eslClient.sendSyncApiCommand(SHOW, "dialplan");}
    public void file                   () { eslClient.sendSyncApiCommand(SHOW, "file");}
    public void timer                  () { eslClient.sendSyncApiCommand(SHOW, "timer");}
    public void calls                  () { eslClient.sendSyncApiCommand(SHOW, "calls");}
    public void channels               () { eslClient.sendSyncApiCommand(SHOW, "channels");}
    public void detailed_calls         () { eslClient.sendSyncApiCommand(SHOW, "detailed_calls");}
    public void bridged_calls          () { eslClient.sendSyncApiCommand(SHOW, "bridged_calls");}
    public void detailed_bridged_calls () { eslClient.sendSyncApiCommand(SHOW, "detailed_bridged_calls");}
    public void aliases                () { eslClient.sendSyncApiCommand(SHOW, "aliases");}
    public void complete               () { eslClient.sendSyncApiCommand(SHOW, "complete");}
    public void chat                   () { eslClient.sendSyncApiCommand(SHOW, "chat");}
    public void management             () { eslClient.sendSyncApiCommand(SHOW, "management");}
    public void modules                () { eslClient.sendSyncApiCommand(SHOW, "modules");}
    public void nat_map                () { eslClient.sendSyncApiCommand(SHOW, "nat_map");}
    public void say                    () { eslClient.sendSyncApiCommand(SHOW, "say");}
    public void interfaces             () { eslClient.sendSyncApiCommand(SHOW, "interfaces");}
    public void interface_types        () { eslClient.sendSyncApiCommand(SHOW, "interface_types");}
    public void tasks                  () { eslClient.sendSyncApiCommand(SHOW, "tasks");}
    public void limits                 () { eslClient.sendSyncApiCommand(SHOW, "limits");}
}
