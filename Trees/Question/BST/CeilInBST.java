//  https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

package Trees.Question.BST;

public class CeilInBST {
    int findCeil(NodeGFG root, int key) {
        int ceil = -1;

        while(root!= null){
            if(root.data==key){
                ceil= root.data;
                return ceil;
            }

            if(key>root.data){
                root = root.right;
            }

            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }


// 2nd approach

    // int ceil=-1;
    // int findCeil(NodeGFG root, int key) {
    //     find(root, key);
    //     return ceil;
    // }

    // void find(NodeGFG root, int key){
    //     if (root == null) return ;

    //     if(root.data>=key){
    //         ceil= root.data;
    //     }
    //     if(key>root.data){
    //         find(root.right, key);
    //     }

    //     else{
    //         find(root.left,key);
    //     }


    // }

}
