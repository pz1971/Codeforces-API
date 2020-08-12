# Class: Codeforces.java
**Description:** Codeforces API can be accessed only through this class. Codeforces.java sends http request to codeforces.com/api and returns data as String in JSON format.
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
| | `Codeforces()` | Constructor |
| `String` | `get(String request)` | `throws Exception` <br> returns a String formatted as JSON data that is the result from http request|
| [CFContest]`[]` | `getContestList()` | `throws Exception` <br> returns an array of [CFContest] object |
| int | `findContestById(CFContest[] contestList, int id)` | Returns the index of [CFContest] object of given `id` in `contestList`.<br> Returns `-1` if there exists no object with that `id` in `contestList`|
|`Pair<`[CFProblem]`[], `[CFProblemStatistics]`[]>`| `getProblemSet()` |`throws Exception`<br> Returns an array of [CFProblem] and an array of [CFProblemStatistics] as a Pair<> object|
|`Pair<`[CFProblem]`[], `[CFProblemStatistics]`[]>`| `getProblemSet(String tags[])` |`throws Exception`<br> Returns an array of [CFProblem] and an array of [CFProblemStatistics] for the given list of tag as a Pair<> object|


<!-- definitions -->
[CFContest]: https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFContest.md
[CFProblem]: https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFProblem.md
[CFProblemStatistics]: https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFProblemStatistics.md