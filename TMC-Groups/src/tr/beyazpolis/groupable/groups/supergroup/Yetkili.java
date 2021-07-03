package tr.beyazpolis.groupable.groups.supergroup;

import tr.beyazpolis.groupable.groups.IGroup;

public class Yetkili implements IGroup {

  public Yetkili() {
    
  }

  @Override
  public String getGroupName() {
    return "yetkili";
  }

  @Override
  public boolean hasStaff() {
    return true;
  }

  @Override
  public boolean hasAdministrator() {
    return false;
  }

  @Override
  public boolean hasChatBypass() {
    return true;
  }

  @Override
  public boolean hasTeleportCooldownBypass() {
    return true;
  }
}
