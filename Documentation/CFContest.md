# Class: CFContest.java
**Description:** Contains informations about Codeforces Contests. **GYM contests are ignored here**.

**Note:** Some of the data might be absent as stated in the official documentation [here](https://codeforces.com/apiHelp/objects#Contest). Thus, some methods may return nothing (e.g., empty strings, 0)
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
|  | `CFContest(JSONObject ob)` | Constructor <br> Collects and saves informations from given JSON data |
| `int` | `getId()` | Returns id of the contest |
| `String` | `getName()` | Returns name of the contest |
| `long` | `getDurationdurationSeconds()` | Returns duration of the contest |
| `long` | `getStartTimeSeconds()` | Returns start time of the contest |
| `long` | `getRelativeTimeSeconds()` | Returns relative start time of the contest |
| `String` | `getPreparedBy()` | Returns handle of the user who created the contest |
| `String` | `getWebsiteUrl()` | Link the contest |
| `contestType` | `getType()` | Type of the contest. <br> Go through the enum contestType for the possible types |
| `contestPhase` | `getType()` | Phase of the contest. <br> Go through the enum contestPhase for the possible Phases |
| `String` | `toString()` | Returns name of the contest |

<br>

| Enum | Keys |
| :---: |:---:|
| contestType | CF, IOI, ICPC |
| contestPhase | BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED |