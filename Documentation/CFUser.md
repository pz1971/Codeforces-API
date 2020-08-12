# Class: CFUser.java
**Description:** Contains informations of a User.
<br><br>

| Returns | Method | Description |
| :---: |:---:| :--- |
||`CFUser(String handle)`|`throws `[InitializationFailedException]<br>Constructor.<br>constructs object sending http request to get informations of user|
||`CFUser(JSONObject ob)`|`throws `[InitializationFailedException]<br>Constructor.<br>constructs object on the basis of the informations from ob|
|`String`|`toString()`|returns basic infromations of user in String format|
|`boolean`|`areSubmissionsLoaded()`|true if user submissions are loaded|
|`boolean`|`areRatingChangesLoaded()`|true if user rating changes are loaded|
|`void`|`loadSubmissions()`|`throws ` [InitializationFailedException] <br>Loads all the submissions of the user|
|`void`|`loadRatingChanges()`|`throws ` [InitializationFailedException] <br>Loads all the rating changes of the user|
|`String`|`getHandle()`|user handle|
|`String`|`getFirstName()`|First name of the user|
|`String`|`getLastName()`|Last name of the user|
|`String`|`getRank()`|Current rank of the user|
|`String`|`getMaxRank()`|Maximum rank of the user|
|`int`|`getRating()`|Current rating of the user|
|`int`|`getMaxRating()`|Maximum rating of the user|
|`int`|`getContribution()`|User contribution point|
|`int`|`getFriendOfCount()`|Number of other user added this user as friend|
|`String`|`getCountry()`|User's country|
|`String`|`getCity()`|User's city|
|`String`|`getOrganization()`|The organization where user works/studies|
|`String`|`getTitlePhoto()`|User's title photo URL.|
|`String`|`getAvatar()`|User's avatar photo URL.|
|[CFSubmission]`[]`|`getSubmissions()`|returns an array of [CFSubmission] objects.<br>**Important: Must check whether submissions are loaded or not. If not, load submissions first. See:** `areSubmissionsLoaded()` **and** `loadSubmissions()`|
|`int`|`getSubmissionCount()`|Number of submissions done by the user. **Load Submissions first**|
|`int`|`getPassedCount()`|Number of successful submissions done by the user. **Load Submissions first**|
|`int`|`getFailedCount()`|Number of failed submissions done by the user. **Load Submissions first**|
|[CFRatingChange]`[]`|`getRatingChanges()`|returns an array of [CFRatingChange] objects.<br>**Important: Must check whether rating changes are loaded or not. If not, load rating changes first. See:** `areRatingChangesLoaded()` **and** `loadRatingChanges()`|
|`int`|`getParticipationCount()`|Number of online contests participated by the user. **Load rating changes first**|

<!-- Definitions -->
[InitializationFailedException]:https://github.com/pz1971/Codeforces-API/blob/master/Documentation/InitializationFailedException.md
[CFSubmission]:https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFSubmission.md
[CFRatingChange]:https://github.com/pz1971/Codeforces-API/blob/master/Documentation/CFRatingChange.md