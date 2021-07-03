package tr.beyazpolis.groupable.features.feature;

import com.mongodb.client.model.Filters;
import java.util.UUID;
import org.bson.Document;
import tr.beyazpolis.database.manager.CollectionManager;
import tr.beyazpolis.database.manager.MongoManager;
import tr.beyazpolis.database.registery.Feature;
import tr.beyazpolis.database.registery.FeatureData;
import tr.beyazpolis.groupable.GroupableMain;
import tr.beyazpolis.groupable.features.feature.data.GroupablePlayer;
import tr.beyazpolis.groupable.features.feature.data.GroupablePlayerData;
import tr.beyazpolis.groupable.rank.Ranks;

public class GroupablePlayerFeature implements Feature {

  private final CollectionManager collectionManager;
  private final GroupableMain groupableMain;

  public GroupablePlayerFeature(GroupableMain groupableMain) {
    this.collectionManager = new CollectionManager("Groups").load();
    this.groupableMain = groupableMain;
  }

  @Override
  public FeatureData getOrCreate(final MongoManager mongoManager, final UUID uuid) {

    final Document found = mongoManager.getDatabase()
      .getCollection(collectionManager.getName())
      .find(Filters.eq("uuid", uuid.toString()))
      .first();
    if (found == null){
      final GroupablePlayerData playerData = new GroupablePlayerData(uuid,new GroupablePlayer(Ranks.CAYLAK,groupableMain.getOyuncu(),uuid),groupableMain);
      Document document = new Document("uuid",uuid.toString());
      document.append("group",playerData.getGroupablePlayer().getGroup().getGroupName());
      document.append("level",playerData.getGroupablePlayer().getRanks().getLevel());
      mongoManager.getDatabase().getCollection(collectionManager.getName()).insertOne(document);
      return playerData;
    } else {
      final String groupName = found.getString("group");
      final int level = found.getInteger("level");
      return new GroupablePlayerData(uuid,new GroupablePlayer(Ranks.getRankOfLevel(level),groupableMain.groupByOfName(groupName),uuid),groupableMain);
    }
  }

  @Override
  public Feature<?> load() {
    collectionManager.load();
    return this;
  }


  public CollectionManager getCollectionManager() {
    return collectionManager;
  }
}
