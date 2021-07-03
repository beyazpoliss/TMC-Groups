package tr.beyazpolis.groupable;

import java.util.UUID;
import org.bukkit.craftbukkit.libs.jline.internal.Nullable;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tr.beyazpolis.database.TMCDatabase;
import tr.beyazpolis.database.manager.LibManager;
import tr.beyazpolis.database.manager.RegisterManager;
import tr.beyazpolis.groupable.features.feature.GroupablePlayerFeature;
import tr.beyazpolis.groupable.features.feature.data.GroupablePlayerData;
import tr.beyazpolis.groupable.groups.IGroup;
import tr.beyazpolis.groupable.groups.supergroup.Oyuncu;
import tr.beyazpolis.groupable.groups.supergroup.Yetkili;
import tr.beyazpolis.groupable.groups.supergroup.Yonetici;

public class GroupableMain extends JavaPlugin implements Listener {

  @Nullable
  private GroupablePlayerFeature groupablePlayerFeature;

  @Nullable
  private Yonetici yonetici;

  @Nullable
  private Yetkili yetkili;

  @Nullable
  private Oyuncu oyuncu;

  @Override
  public void onEnable() {
    this.groupablePlayerFeature = new GroupablePlayerFeature(this);
    this.oyuncu = new Oyuncu();
    this.yetkili = new Yetkili();
    this.yonetici = new Yonetici();
    RegisterManager.register(groupablePlayerFeature);
  }

  @Override
  public void onDisable() {

  }

  public GroupablePlayerData getGroupablePlayerData(UUID uuid){
    return (GroupablePlayerData) LibManager.getLibManager().getDatabase().getProfileManager().getOrCreate(uuid).getFeatureData(GroupablePlayerFeature.class);
  }

  public IGroup groupByOfName(final String groupName){
    switch (groupName){
      case "oyuncu":
        return oyuncu;
     case "yetkili":
       return yetkili;
     case "yonetici" :
       return yonetici;
    }
    return oyuncu;
  }

  public GroupablePlayerFeature getGroupablePlayerFeature() {
    return groupablePlayerFeature;
  }

  public Oyuncu getOyuncu() {
    return oyuncu;
  }

  public Yetkili getYetkili() {
    return yetkili;
  }

  public Yonetici getYonetici() {
    return yonetici;
  }
}
