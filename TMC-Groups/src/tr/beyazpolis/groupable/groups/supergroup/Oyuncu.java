package tr.beyazpolis.groupable.groups.supergroup;

import tr.beyazpolis.groupable.groups.IGroup;

public class Oyuncu implements IGroup {

  public Oyuncu() { }

  @Override
  public String getGroupName() {
    return "oyuncu";
  }

  @Override
  public boolean hasStaff() {
    return false;
  }

  @Override
  public boolean hasAdministrator() {
    return false;
  }

  @Override
  public boolean hasChatBypass() {
    return false;
  }

  @Override
  public boolean hasTeleportCooldownBypass() {
    return false;
  }
}
