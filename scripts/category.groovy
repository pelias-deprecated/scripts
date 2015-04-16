// expects category_weights passed in with weight mapping
if (doc.containsKey('category')) {
  score = 0
  categories=doc['category'].value;
  categories.each { category -> 
  	score = score + (( category in category_weights ) ? category_weights[ category ] : 0) 
  }
  return score
} else { 
  return 0 
}