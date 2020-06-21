package trees;

public class CousinsInBT {
    public boolean isCousins(Node root, int x, int y) {
        int xLevel = new LevelofNode().getLevel(root, x);
        int yLevel = new LevelofNode().getLevel(root, y);

        boolean sibings = new SiblingsInBT().isSibings(root, x, y);
        return (xLevel == yLevel && !sibings);
    }
}
// should be on same level but not siblings