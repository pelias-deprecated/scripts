/**
 * See https://github.com/pelias/scripts/issues/5
*/

input.tokenize(' ').size() == doc['name.default'].values.size() ? 1 : 0
