package tr.beyazpolis.groupable.rank;

public enum Ranks {

  //RANKS
  CAYLAK("&eÇaylak",0),
  KALFA("&eKalfa", 1),
  USTA("&aUsta", 2),
  USTAD("&aÜstad", 3),
  ASIL("&2Asil", 4),
  KAHRAMAN("&2Kahraman", 5),
  SAVASCI("&6Savaşçı", 6),
  SOVALYE("&6Şövalye", 7),
  ARISTOKRAT("&cAristokrat", 8),
  EFSANEVI("&cEfsanevi", 9),
  BUYUCU("&dBüyücü",10),
  //VIPS
  VIP("&6VIP",11),
  VIPPLUS("&6VIP+",12),
  MVIP("&2MVIP",13),
  MVIPPLUS("&2MVIP+",14),
  TVIP("&4TVIP",15),
  TVIPPLUS("&4TVIP+",16),
  //STAFF
  REHBER("&2Rehber",17),
  MODERATOR("&3Yardımcı",18),
  //ADMINISTRATORS
  YONETICI("&4Yönetici", 19);

  private final String name;
  private final int level;

  private Ranks(String name, int level){
    this.name = name;
    this.level = level;

  }

  public static Ranks getRankOfLevel(int level){
    for (Ranks ranks : values()) {
      if (ranks.getLevel() == level){
        return ranks;
      }
    }
    return CAYLAK;
  }

  public String getName() {
    return name;
  }

  public int getLevel() {
    return level;
  }
}
