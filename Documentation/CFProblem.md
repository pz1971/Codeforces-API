# Class: CFProblem.java
**Description:** Contains informations of an specific Codeforces problem.

**Note:** Some of the data might be absent as stated in the official documentation [here](https://codeforces.com/apiHelp/objects#Problem). Thus, some methods may return nothing (e.g., empty strings, 0)
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
|  |`CFProblem(JSONObject ob)`|`Constructor`<br>constructs object on the basis of the information from `ob`|
| `int` |`getContestId()`|Returns contest id|
| `String` |`getIndex()`|Returns index on the respective contest (e.g., A, B, C1, E2)|
| `String` |`getName()`|Returns problem name|
| `String[]` |`getTags()`|Returns problem tags|
| `String` | `toString()` | returns basic informations in String format |