# Minimum Swaps
## Medium
<div class="problems_problem_content__Xm_eO"><p dir="ltr"><span style="font-size:18px">A flock of sheep is running east along a straight, narrow road. Each one is running at its own constant speed. Whenever a sheep catches up to the one in front of it, it has to slow down and follow at the speed of the other sheep. You are in a mobile crane behind the flock, chasing the sheep towards the barn at the end of the road. The arm of the crane allows you to pick up any sheep momentarily, let the sheep behind it pass underneath, and place the picked-up sheep back down. This operation takes no time and can only be performed on a pair of sheep that are immediately next to each other, even if 3 or more sheep are in a row, one after the other.</span></p>

<p dir="ltr"><span style="font-size:18px">Given the initial locations (Xi) at time 0 and natural speeds (Vi) of the sheep, as well as the location of the barn (B), what is the minimum number of swaps you need to perform with your crane in order to have at least K of the N sheep arrive at the barn no later than time T?</span></p>

<p dir="ltr"><span style="font-size:18px">You may think of the sheep as points moving along a line. Even if 3 or more sheep are at the same location, next to each other, picking up one of them will only let one of the other two pass through. Any swap is instantaneous, which means that you may perform multiple swaps at the same time, but each one will count as a separate swap.</span></p>

<p dir="ltr"><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N=5
k=3
B=10
T=5
X[]={0,2,5 ,6, 7}
V[]={1,1,1,1,4}
<strong>Output:</strong>
0
<strong>Explanation:</strong>
Sheep 5,4 and 3 will reach the barn before or at 5 secs.</span></pre>

<p dir="ltr"><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong>
N=5
K=3
B=10
T=5
X[]={0,2,3,4,7}
V[]={2,1,1,1,4}
<strong>Output:</strong>
-1
<strong>Explanation:</strong>
At max 2 sheep can reach the barn within or at 5 secs so the
answer is -1.</span></pre>

<p dir="ltr">&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>minimumSwaps()</strong>&nbsp;which takes the array pos[],v[], N, K, B, and T as input parameters&nbsp;and returns the minimum number of swaps required. If it is not possible to make k sheep reach the barn before or on T seconds then return&nbsp;<strong>-1</strong>.</span><br>
<br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(1)</span><br>
<br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1&lt;=<strong>N</strong>&lt;=10<sup>5</sup><br>
1&lt;=<strong>k</strong>&lt;=N.<br>
1 ≤&nbsp;<strong>B</strong>&nbsp;≤ 1,000,000,000<br>
1 ≤&nbsp;<strong>T</strong>&nbsp;≤ 1,000<br>
0 ≤ <strong>POS<sub>i</sub></strong>&nbsp;&lt;&nbsp;<strong>B</strong><br>
1 ≤&nbsp;<strong>V<sub>i</sub></strong>&nbsp;≤ 100<br>
All the <strong>POS<sub>i</sub></strong>'s will be&nbsp;in increasing order.</span></p>
</div>