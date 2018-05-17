
import React from 'react';
import CompInfo from './CompInfo';
import TextInput from './TextInput';
//import {Typeahead} from 'react-bootstrap-typeahead'; //UNCOMMENT this line if you are using the react-bootstrap-typeeahead component


class StockTicker extends React.Component {

    /**
     * TODO
     * Prefetch the data required to display options fo the typeahead component. Initialize a state array with
     * this data and pass it via props to the typeahead component that will be rendered.
     * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Data.md
     * e.g.
     * options : [
     *   GS,
     *   AAPL,
     *   FB,
     * ]
     * If you are having difficulty with this, you may hard code the options array from the company data provided for the
     * services.
     */
    constructor(props) {
        super(props);
        this.state = {
            showcompanyinfo: false, //TODO: Use this boolean to determine if the company information should be rendered
            
            company : {
                symbol: 'GS',
                name: 'Goldman Sachs',
                city: 'New York',
                state: 'New York',
                sector: 'Banking',
                industry: 'Financial Services'
            }
            
            /**
             * TODO
             * Add any additional state to pass via props to the typeahead component.
             */
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        
            /**
             * TODO
             * Make a request to your service to GET company information for the selected company and set it in state.
             * The information you will need to determine the URL will be contained in the 'event[0]' object,
             * e.g. event[0] (event[0].symbol if your options are an array of objects) provides you the symbol selected.
             * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
             * your service is running. Your service MUST be running for the request to work (you can add a catch function
             * to handle errors). If you successfully retrieve this information, you can set the state objects
             * and render it.
             */
            this.setState({showcompanyinfo: true});
            this.setState({company : {'name': this.props.searchedCompany }});
            // to the App component, which will handle it via its own onChane prop,
            // ultimately  used to fetch the data for the LineChart component.

        
    }

   


    render() {

     
        /**
         * TODO
         * Render a typeahead component that uses the data prefetched from your service to display a list of companies or
         * ticker symbols. The props you use can be stored as state objects.
         * On change should fetch the company information and display Company, Ticker Symbol, City, State/Country, Sector, and Industry information.
         * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Props.md
         */


        return (
            <div className="stockticker">
           
                <div className="ticker-input">
                    <h1><strong>Stock Ticker</strong></h1>
                    {/* <p> {this.props.searchedCompany } </p> */}
                    
                    <div className="stockticker-typeahead">
                        {/* useful props if you decide to use react-bootstrap-typeahead
                        <Typeahead
                             align=
                             filterBy=
                             labelKey=
                             onChange={this.handleChange}
                             minLength=
                             placeholder="Company Name/Ticker"
                             options=
                        />
                        */}
                    </div>
                </div>


                
                {this.state.showcompanyinfo? CompInfo(this.state.company) : <div> Sorry, incorrect Company name! </div>}
                
                <br/>
               
               <button onClick={this.handleChange} > Press me! </button>
                        
                
            </div>
        );
    }

}

//Don't forget to export your component!
export default StockTicker;