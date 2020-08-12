# Class: CFProblemStatistics.java
**Description:** Contains Statistics of a problem (i.g., solve count).

**Note:** Some of the data might be absent as stated in the official documentation [here](https://codeforces.com/apiHelp/objects#ProblemStatistics). Thus, some methods may return nothing (e.g., empty strings, 0)
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
|  | `CFProblemStatistics(JSONObject ob)` | `constructor`<br> constructs object on the basis of the informations from `ob` |
| `int` | `getContestId()` | id of the contest |
| `String` | `getIndex()` | index of the problem in respective contest (i.g., A, B, C1, E2) |
| `int` | `getSolveCount()` | number of users, who solved the problem |
| `String` | `toString()` | returns informations in String format |