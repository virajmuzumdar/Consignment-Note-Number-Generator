Consignment Note Number Generator
Within the freight industry every shipment of items has a Consignment Note Number (Connote Number). When we create a new consignment, we must generate an industry wide unique ID. For example a shipment sent with Freightmate Couriers Co may be: FMCC123ABC00000196051 This ID is made up of multiple parts. A Carrier prefix, an account number, a consignment index within an allowed range, digits and a checksum. In the above example these parts are as follows:

Prefix: FMCC
Account Number: 123ABC
Digits: 10
Consignment Index: 19605
Checksum: 1
Range 19000-20000
A connote number is calculated by concatinating these parts together in the correct order. As a part of this process the consignment index must be incremented from last used index (In our example the next index is 19606), and the new index must be within the provided range to be valid. The number should be padded with 0's to make the index "Digits" characters long. 19605 -> 0000019605 when digits is 10. The checksum must also be calculated as described in the following.

The checksum is calculated by 
 - Adding every second number in the index from the right starting at the first element
  ( 5 + 6 + 1 + 0 + 0 = 12 )
 - Multiply that number by 3
  ( 12 * 3 = 36 )
 - Adding every second number in the index from the right starting at the second element
( 0 + 9 + 0 + 0 + 0 = 9 )
 - Multiply that number by 7
    ( 9 * 7 = 63)
 - Add the results of step 1 and step 2
  ( 63 + 36 = 99 )
 - Get the difference between that number and the next multiple of 10, this is your checksum
  ( 100 - 99 = 1 )
Please write a function that accepts a carrier account (POJO representing the below object is fine) as a parameter and generates the next connote number in that series.

# input
{
  "carrierName":"FreightmateCourierCo",
  "accountNumber":"ABC123",
  "digits":10,
  "lastUsedIndex":19604,
  "rangeStart":19000,
  "rangeEnd":20000
}
# output
FMCC123ABC00000196051
Please also explain how to run your code.
