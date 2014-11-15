package Set_TDD;

import java.util.*;

class Node {
	String val;
	Node right, left;
}

public class TDD {
	List<List<String>> bfs = new ArrayList<List<String>>();
	Queue<Node> bfsQ = new LinkedList<Node>();

	void addNode(Node root, int level) {
		if (root == null)
			return;
		else {
			List<String> currLevel = bfs.get(level);
			if (currLevel == null)
				currLevel = new ArrayList<String>();
			currLevel.add(root.val);
			bfs.add(level, currLevel);
			addNode(root.left, level + 1);
			addNode(root.right, level + 1);

		}
	}

	List<List<String>> bfs(Node root) {
		if (root == null)
			return Collections.EMPTY_LIST;
		else {
			bfsQ.add(root);
			List<String> currLevel = new ArrayList<String>();
			currLevel.add(root.val);
			bfs.add(currLevel);

			int currlevel = 0;
			int prevLevel = 0;
			while (!bfsQ.isEmpty()) {
				Node curr = bfsQ.remove();
				List<String> current = new ArrayList<String>();
				if (curr.right != null) {
					current.add(curr.right.val);
					bfsQ.add(curr.right);
				}
				if (curr.left != null) {
					current.add(curr.right.val);
					bfsQ.add(curr.left);
				}
				currlevel++;
				bfs.add(currlevel, current);
			}
		}
		return bfs;
	}
}
