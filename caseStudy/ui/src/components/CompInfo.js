import React from 'react';

function CompInfo(props){
        return(
            <div>
                <p> 
                    <b> Company </b> : {props.name} 
                    <br/>
                    <b>Ticker Symbol </b>: {props.symbol}
                    <br/>
                    <b>City </b>: {props.city}
                    <br/>
                    <b>State </b>: {props.state}
                    <br/>
                    <b>Sector </b>: {props.sector}
                    <br/>
                    <b>Industry </b>: {props.industry}
                    <br/>
                
                </p>
            </div>
        );
    }

export default CompInfo;