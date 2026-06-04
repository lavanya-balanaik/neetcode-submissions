class Twitter {

    private int timestamp;

    private Map<Integer, Set<Integer>> following;
    private Map<Integer, List<Tweet>> tweets;

    public Twitter() {
        timestamp = 0;
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId, new ArrayList<>());

        tweets.get(userId).add(
            new Tweet(tweetId, timestamp++)
        );
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        Set<Integer> users = new HashSet<>();

        users.add(userId);

        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        PriorityQueue<TweetNode> maxHeap =
            new PriorityQueue<>(
                (a, b) -> b.tweet.time - a.tweet.time
            );

        for (int user : users) {

            if (!tweets.containsKey(user)) {
                continue;
            }

            List<Tweet> userTweets = tweets.get(user);

            int lastIndex = userTweets.size() - 1;

            maxHeap.offer(
                new TweetNode(
                    user,
                    lastIndex,
                    userTweets.get(lastIndex)
                )
            );
        }

        while (!maxHeap.isEmpty() && result.size() < 10) {

            TweetNode current = maxHeap.poll();

            result.add(current.tweet.tweetId);

            int nextIndex = current.index - 1;

            if (nextIndex >= 0) {

                List<Tweet> userTweets =
                    tweets.get(current.userId);

                maxHeap.offer(
                    new TweetNode(
                        current.userId,
                        nextIndex,
                        userTweets.get(nextIndex)
                    )
                );
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) {
            return;
        }

        following.putIfAbsent(
            followerId,
            new HashSet<>()
        );

        following.get(followerId)
                 .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId)
                 .remove(followeeId);
    }

    class Tweet {

        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    class TweetNode {

        int userId;
        int index;
        Tweet tweet;

        TweetNode(
            int userId,
            int index,
            Tweet tweet
        ) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }
}