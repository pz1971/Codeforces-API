# Class: CFSubmission.java
**Description:** Contains informations of a submission.
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
||`CFSubmission(JSONObject ob)`|`constructor` <br> Constructs object on the basis of the informations from 'ob'|
|`int`|`getId()`|Unique Submission Id|
|`long`|`getCreationTimeSeconds()`|Time, when submission was created, in **unix-format**.|
|`long`|`getRelativeTimeSeconds()`|Number of seconds, passed after the start of the contest (or a virtual start for virtual parties), before the submission.|
|[CFProblem]|getProblem|returns a `CFProblem` object|
|`String`|`getProgrammingLanguage()`|Programming language that was used in this submission|
|`verdictType`|`getVerdict()`|Verdict of the submission. <br> Go through the `enum verdictType` for the possible verdicts|
|`testsetType`|`getTestset()`|testSet used for judging the submission. <br> Go through the `enum testsetType` for the possible verdicts|
|`int`|`getPassedTestCount()`|Number of passed tests|
|`int`|`getTimeConsumedMillis()`|Maximum time in milliseconds, consumed by solution for one test.|
|`int`|`getMemoryConsumedBytes()`| Maximum memory in bytes, consumed by solution for one test.|
|`String`|`toString()`|returns basic data in String format|

<br>

| Enum | keys |
| :---: |:---:|
|`verdictType`|`FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED`|
|`testsetType`|`SAMPLES, PRETESTS, TESTS, CHALLENGES, TESTS1, TESTS2, TESTS3, TESTS4, TESTS5, TESTS6, TESTS7, TESTS8, TESTS9, TESTS10`|

<!-- definitions -->
[CFProblem]:https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFProblem.md