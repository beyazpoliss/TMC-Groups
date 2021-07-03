package tr.beyazpolis.groupable.groups;

public interface IGroup {

  String getGroupName();

  boolean hasStaff();

  boolean hasAdministrator();

  boolean hasChatBypass();

  boolean hasTeleportCooldownBypass();




}
