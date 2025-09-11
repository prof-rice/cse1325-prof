public enum Pitch {
  C("C", 60),
  Db("D♭", 61), D("D", 62),
  Eb("E♭", 63), E("E", 64),
  F("F", 65),
  Gb("G♭", 66), G("G", 67),
  Ab("A♭", 68), A("A", 69),
  Bb("B♭", 70), B("B", 71);
  private int value;
  private String string;
  private Pitch(String string, int value) {
      this.string = string;
      this.value = value;
  }
  @Override
  public String toString() {
      return string;
  }
  public int toValue() {
      return value;
  }
}
