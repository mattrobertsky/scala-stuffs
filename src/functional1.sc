var ids = java.util.TimeZone.getAvailableIDs().map(value => value.split("/")).filter(_.length > 1).map(a=>a(1)).grouped(10).map(a=>a(0)).toArray
// above gives you the first element of each of the groups, if you want the first group you could do below instead
var idsTwo = java.util.TimeZone.getAvailableIDs().map(value => value.split("/")).filter(_.length > 1).map(a=>a(1)).grouped(10).next()
// TODO revisit


