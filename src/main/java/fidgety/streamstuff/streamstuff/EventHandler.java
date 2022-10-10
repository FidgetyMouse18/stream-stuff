package fidgety.streamstuff.streamstuff;

import fidgety.streamstuff.streamstuff.Items.TotallySafeCarrot;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
    EventHandler() {
        MinecraftForge.EVENT_BUS.register(TotallySafeCarrot.class);
    }
}
