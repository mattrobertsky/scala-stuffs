// first we need to make some words

//val text = scala.io.Source.fromFile("src/80day10.txt")
//val lines = try text.mkString finally text.close()

val someText = "Certainly an Englishman, it was more doubtful whether Phileas Fogg\nwas a Londoner.  He was never seen on 'Change, nor at the Bank,\nnor in the counting-rooms of the \"City\"; no ships ever came into\nLondon docks of which he was the owner; he had no public employment;\nhe had never been entered at any of the Inns of Court, either at the Temple,\nor Lincoln's Inn, or Gray's Inn; nor had his voice ever resounded\nin the Court of Chancery, or in the Exchequer, or the Queen's Bench,\nor the Ecclesiastical Courts.  He certainly was not a manufacturer;\nnor was he a merchant or a gentleman farmer.  His name was strange\nto the scientific and learned societies, and he never was known\nto take part in the sage deliberations of the Royal Institution\nor the London Institution, the Artisan's Association, or the\nInstitution of Arts and Sciences.  He belonged, in fact,\nto none of the numerous societies which swarm in the English capital,\nfrom the Harmonic to that of the Entomologists, founded mainly\nfor the purpose of abolishing pernicious insects."

someText.replace("[^A-Za-z]", "")

