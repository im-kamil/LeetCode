# Queries on a Matrix
## Hard
<div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">You are given a matrix of dimension n*n. All the cells are initially, zero.&nbsp;You are given Q queries, which contains 4 integers&nbsp;a b c d where (a,b) is the&nbsp;TOP LEFT cell and (c,d) is the Bottom Right cell of a submatrix. Now, all the cells of this submatrix have&nbsp;to be incremented by one. After all the Q queries have been performed. Your task is to find&nbsp;the final resulting Matrix.<br>
<strong>Note</strong> : Zero-Based Indexing is used for cells of the matrix.&nbsp;</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>n = 6, q = 6,
Queries = {
{4,0,5,3},
{0,0,3,4},
{1,2,1,2},
{1,1,2,3},
{0,0,3,1},
{1,0,2,4}}.
<strong>Output: </strong>
2 2 1 1 1 0
3 4 4 3 2 0 
3 4 3 3 2 0
2 2 1 1 1 0
1 1 1 1 0 0
1 1 1 1 0 0
<strong>Explanation:</strong>After incrementing all the
sub-matrices of given queries we will 
get the final output.</span>

</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input: </strong>n = 4, q = 2,
Queries = {
{0,0,3,3},
{0,0,2,2}}.
<strong>Output: </strong>
2 2 2 1 
2 2 2 1  
2 2 2 1 
1 1 1 1 
<strong>Explanation:</strong>After incrementing all the
sub-matrices of given queries we will
get the final output.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read or print anything. Your task is to complete the function&nbsp;<strong>solveQueries()&nbsp;</strong>which takes n and Queries and input parameter and returns a matrix after performing all the queries.</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(n<sup>2</sup>)<br>
<strong>Expected Space Complexity:&nbsp;</strong>O(n<sup>2</sup>)</span><br>
&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n &lt;= 1000<br>
0 &lt;= a &lt;= c &lt;&nbsp;n<br>
0 &lt;= b &lt;= d &lt;&nbsp;n<br>
1 &lt;= No. of Queries &lt;= 1000</span></p>
</div>