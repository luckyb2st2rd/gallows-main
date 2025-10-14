package gallows;

public class PictureGallows {
    private static final String[] STAGE = {
            """
           +----+
           |    |
           |    |
           |
           |
           |
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |
           |
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |    |
           |
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |   /|
           |
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |   /|\\
           |
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |   /|\\
           |   /
      ===============
    """,
            """
           +----+
           |    |
           |    |
           |    O
           |   /|\\
           |   / \\
      ===============
    """
    };

    public static int maxMistakes() {
        return STAGE.length - 1;
    }

    public static String picture(int mistakes) {
        int i = mistakes;

        if (i < 0) {
            i = 0;
        }

        if (i >= STAGE.length) {
            i = STAGE.length - 1;
        }
        return STAGE[i];
    }
}
