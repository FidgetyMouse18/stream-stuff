package fidgety.streamstuff.streamstuff;

import fidgety.streamstuff.streamstuff.Items.TotallySafeCarrot;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemManager {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Streamstuff.MODID);
    public static final RegistryObject<Item> TotallySafeCarrot = ITEMS.register("totally_safe_carrot", TotallySafeCarrot::new);


}
