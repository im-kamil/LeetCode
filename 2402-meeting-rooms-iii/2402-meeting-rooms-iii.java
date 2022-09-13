class Solution {
    public int mostBooked(int n, int[][] meetings) {
         Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // {endTime,
                                                                                                              // room}
        int[] roomCount = new int[n]; // number of meeting of the room
        int result = 0;

        for (int i = 0; i < n; i++)
            queue.add(new int[] { 0, i });

        for (int[] item : meetings) {
            int time = item[0]; // new meeting start time

            while (queue.peek()[0] < time) // order all available room by room index
                queue.add(new int[] { time, queue.poll()[1] });

            int[] current = queue.poll();
            int curRoom = current[1];
            int meetingEndTime = current[0] + (item[1] - item[0]); // current room endTime + this meeting time
            roomCount[curRoom]++;

            if (roomCount[curRoom] > roomCount[result]) // update result
                result = curRoom;
            else if (roomCount[curRoom] == roomCount[result])
                result = Math.min(result, curRoom);

            queue.add(new int[] { meetingEndTime, curRoom });
        }

        return result;
    }
}