package com.neetcode150.heapPriorityQueue;

import java.util.*;

/**
 * Implement a simplified version of Twitter which allows users to post tweets, follow/unfollow each other, and view the 10 most recent tweets within their own news feed.
 * Users and tweets are uniquely identified by their IDs (integers).
 *
 * Implement the following methods:
 * Twitter() Initializes the twitter object.
 * void postTweet(int userId, int tweetId) Publish a new tweet with ID tweetId by the user userId. You may assume that each tweetId is unique.
 * List<Integer> getNewsFeed(int userId) Fetches at most the 10 most recent tweet IDs in the user's news feed. Each item must be posted by users who the user is following or by the user themself. Tweets IDs should be ordered from most recent to least recent.
 * void follow(int followerId, int followeeId) The user with ID followerId follows the user with ID followeeId.
 * void unfollow(int followerId, int followeeId) The user with ID followerId unfollows the user with ID followeeId.
 *
 * Example 1:
 * Input: ["Twitter", "postTweet", [1, 10], "postTweet", [2, 20], "getNewsFeed", [1], "getNewsFeed", [2], "follow", [1, 2], "getNewsFeed", [1], "getNewsFeed", [2], "unfollow", [1, 2], "getNewsFeed", [1]]
 * Output: [null, null, null, [10], [20], null, [20, 10], [20], null, [10]]
 *
 * Explanation:
 * Twitter twitter = new Twitter();
 * twitter.postTweet(1, 10); // User 1 posts a new tweet with id = 10.
 * twitter.postTweet(2, 20); // User 2 posts a new tweet with id = 20.
 * twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
 * twitter.getNewsFeed(2);   // User 2's news feed should only contain their own tweets -> [20].
 * twitter.follow(1, 2);     // User 1 follows user 2.
 * twitter.getNewsFeed(1);   // User 1's news feed should contain both tweets from user 1 and user 2 -> [20, 10].
 * twitter.getNewsFeed(2);   // User 2's news feed should still only contain their own tweets -> [20].
 * twitter.unfollow(1, 2);   // User 1 follows user 2.
 * twitter.getNewsFeed(1);   // User 1's news feed should only contain their own tweets -> [10].
 * */

public class DesignTwitter {
    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;

    public DesignTwitter() {
        this.count = 0;
        this.tweetMap = new HashMap<>();
        this.followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count,tweetId});
        if(tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
        count--;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        if (followMap.get(userId).size() > 10) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
            for (int followeeId : followMap.get(userId)) {
                if (!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{-tweet[0],tweet[1], followeeId, index - 1});
                if(maxHeap.size() > 10) {
                    maxHeap.poll();
                }
            }
            while(!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                minHeap.offer(new int[] {-top[0],top[1], top[2], top[3]});
            }
        } else {
            for (int followeeId : followMap.get(userId)) {
                if (!tweetMap.containsKey(followeeId)) continue;
                List<int[]> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index - 1});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] top = minHeap.poll();
            res.add(top[1]);
            int nextIndex = top[3];
            if (nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(top[2]);
                int[] nextTweet = tweets.get(nextIndex);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], top[2], nextIndex - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }

}
