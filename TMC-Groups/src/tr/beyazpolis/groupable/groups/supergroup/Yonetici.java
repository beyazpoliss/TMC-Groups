package tr.beyazpolis.groupable.groups.supergroup;

import tr.beyazpolis.groupable.groups.IGroup;

public class Yonetici implements IGroup {


  public Yonetici() {
  }

  @Override
  public String getGroupName() {
    return "yonetici";
  }


  @Override
  public boolean hasStaff() {
    return true;
  }

  @Override
  public boolean hasAdministrator() {
    return true;
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