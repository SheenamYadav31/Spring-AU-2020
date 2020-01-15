const initState = {
	fruitsArray: []
}

const fruits = (state = initState, action ) => {
	if(action.type === 'CLICKED_FRUIT'){
		if(action.fruitsArray){
			console.log(action);
			// var temp = state.fruitsArray;
			// temp.push(fruitsArray);
			return {...state, fruitsArray: state.fruitsArray.concat(action.fruitsArray)}
		}
	}
	return state;
}
export default fruits;