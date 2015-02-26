if (doc.containsKey('popularity')) { 
  return doc['popularity'].value 
} else {
  return 0
}