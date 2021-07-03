package tr.beyazpolis.groupable.features.feature.data;

import com.mongodb.client.model.Filters;
import java.util.UUID;

import org.bson.Document;

import tr.beyazpolis.database.manager.MongoManager;

import tr.beyazpolis.database.registery.FeatureData;
import tr.beyazpolis.groupable.GroupableMain;
import tr.beyazpolis.groupable.features.feature.GroupablePlayerFeature;
import tr.beyazpolis.groupable.rank.Ranks;

public class GroupablePlayerData implements FeatureData {

  private final GroupablePlayer groupablePlayer;
  private final UUID uuid;

  private final GroupableMain groupableMain;

  public GroupablePlayerData(final UUID uuid,final GroupablePlayer groupablePlayer,final GroupableMain groupableMain) {
    this.groupablePlayer = groupablePlayer;
    this.uuid = uuid;
    this.groupableMain = groupableMain;
  }

  @Override
  public void save(final MongoManager mongoManager, final UUID uuid) {
    final Document found = mongoManager.getDatabase()
      .getCollection(groupableMain.getGroupablePlayerFeature().getCollectionManager().getName())
      .find(Filters.eq("uuid", uuid.toString()))
      .first();
    if (found == null){
      final GroupablePlayer varGroupable = new GroupablePlayer(Ranks.CAYLAK, groupableMain.groupByOfName("oyuncu"),uuid);
      final GroupablePlayerData playerData = new GroupablePlayerData(uuid,varGroupable,groupableMain);
      Document document = new Document("uuid",uuid.toString());
      document.append("group",playerData.getGroupablePlayer().getGroup().getGroupName());
      document.append("level",playerData.getGroupablePlayer().getRanks().getLevel());
      mongoManager.getDatabase().getCollection(groupableMain.getGroupablePlayerFeature().getCollectionManager().getName()).insertOne(document);
    } else {
      final Document updateValue = new Document("group",groupablePlayer.getGroup().getGroupName());
      updateValue.append("level",groupablePlayer.getRanks().getLevel());
      final Document updater = new Document("$set",updateValue);
      mongoManager.getDatabase().getCollection(groupableMain.getGroupablePlayerFeature().getCollectionManager().getName()).updateOne(found, updater);
    }
  }

  public GroupablePlayer getGroupablePlayer() {
    return groupablePlayer;
  }

  public UUID getUuid() {
    return uuid;
  }
}
