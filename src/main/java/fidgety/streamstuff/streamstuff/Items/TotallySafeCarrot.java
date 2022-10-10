package fidgety.streamstuff.streamstuff.Items;

import fidgety.streamstuff.streamstuff.ItemManager;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TotallySafeCarrot extends Item {

    private static final FoodProperties food = (new FoodProperties.Builder()).nutrition(3)
            .saturationMod(1)
            .alwaysEat()
            .build();

    public TotallySafeCarrot() {
        super(new Properties()
                .tab(CreativeModeTab.TAB_FOOD)
                .food(food)
        );
    }
    /*
    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Player player = context.getPlayer();
        if(player == null) {
            return super.onItemUseFirst(stack, context);
        }
        Vec3 pos = player.position();
        player.level.explode(player, pos.x, pos.y, pos.z, 10.0f, Explosion.BlockInteraction.BREAK);
        return super.onItemUseFirst(stack, context);
    }
    */
    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if(event.getItem().getItem() == ItemManager.TotallySafeCarrot.get()) {
            Entity player = event.getEntity();
            if(player instanceof Player) {
                Vec3 pos = player.position();
                player.level.explode(player, pos.x, pos.y, pos.z, 10.0f, Explosion.BlockInteraction.BREAK);
                DamageSource damageSource = new DamageSource("totally_safe_carrot").bypassArmor().setExplosion();
                player.hurt(damageSource, 1000000);
            }

        }
    }
}
