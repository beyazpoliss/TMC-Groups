package tr.beyazpolis.groupable.features.feature.data;

import java.util.UUID;
import tr.beyazpolis.groupable.groups.IGroup;
import tr.beyazpolis.groupable.rank.Ranks;

public class GroupablePlayer {

  private Ranks ranks;
  private IGroup group;
  private final UUID uuid;

  public GroupablePlayer(final Ranks ranks, final IGroup group,final UUID uuid) {
    this.ranks = ranks;
    this.group = group;
    this.uuid = uuid;
  }

  public void setGroup(final IGroup group,final int level) {
    this.group = group;
    setRanks(level);
  }

  public void setGroup(final IGroup group,final Ranks ranks){
    this.group = group;
   setRanks(ranks);
  }

  public void setRanks(final int level){
    setRanks(Ranks.getRankOfLevel(level));
  }

  public void setRanks(final Ranks ranks) {
    this.ranks = ranks;
  }

  public IGroup getGroup() {
    return group;
  }

  public Ranks getRanks() {
    return ranks;
  }

  public UUID getUuid() {
    return uuid;
  }
}
