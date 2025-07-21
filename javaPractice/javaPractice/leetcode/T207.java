package leetcode;

import java.util.*;

public class T207 {
    public static void main(String[] args){
        int numCourses = 2;int[][] prerequisites = {{1,0},{0,1}};

        Set<Integer>[] targetSet = new HashSet[numCourses],needSet = new HashSet[numCourses];
        int i = 0;
        for(i = 0; i < prerequisites.length; i++){
            targetSet[i] = new HashSet<>();
            needSet[i] = new HashSet<>();

        }

        for(i = 0; i < prerequisites.length; i++){
            targetSet[prerequisites[i][1]].add(prerequisites[i][0]);
            needSet[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        boolean isChanged = true;
        boolean[] hasLearned = new boolean[numCourses];
        Arrays.fill(hasLearned, false);

        while(isChanged){
            isChanged =  false;
            for(i = 0;i<numCourses;i++){
                if(needSet[i].size()==0){
                    for(int j:targetSet[i]){
                        needSet[j].remove(i);
                    }
                    hasLearned[i] = true;
                }
            }

        }

        isChanged = true;
        for(i = 0 ;i<numCourses;i++){
            if(!hasLearned[i]){
                isChanged = false;
                break;
            }
        }

        if (isChanged){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

    }




}
