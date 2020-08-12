# Class: CFRatingChange.java
**Description:** Rating change of an specific user
<br><br>
| Returns | Method | Description |
| :---: |:---:| :--- |
||`CFRatingChange(JSONObject ob)`|`constructor`<br> constructs object on the basis of the informations from `ob`|
|`int`|`getContestId()`|returns contest id|
|`String`|`getContestName()`|returns contest name|
|`String`|`getHandle()`|returns user handle|
|`int`|`getRank()`|returns user rank in that contest|
|`long`|`getRatingUpdateTimeSeconds()`|Time, when rating for the contest was update, in unix-format.|
|`int`|`getOldRating()`|Old rating (rating before changes)|
|`int`|`getNewRating()`|New rating (rating after changes)|
|`String`|toString()|Returns basic informations in String format|