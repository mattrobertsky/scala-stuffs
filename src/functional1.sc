var ids = java.util.TimeZone.getAvailableIDs().map(value => value.split("/")).filter(_.length > 1).map(a=>a(1)).grouped(10).map(a=>a(0)).toArray
// above gives you the first element of each of the groups, if you want the first group you could do below instead
var idsTwo = java.util.TimeZone.getAvailableIDs().map(value => value.split("/")).filter(_.length > 1).map(a=>a(1)).grouped(10).next()

// both are wrong as the post filter map is getting the second rather than the last item from the array resulting from the split
// this gets the last item from the slit
var idsThree = java.util.TimeZone.getAvailableIDs().map(value => value.split("/")).filter(_.length > 1).map(a=>a.last).grouped(10).map(a=>a(0)).toArray

idsThree == ids

var foo = "one/two".split("/").last

