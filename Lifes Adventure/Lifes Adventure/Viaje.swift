//
//  Viaje.swift
//  Lifes Adventure
//
//  Created by Daniel Roldan Chavez on 19/02/17.
//  Copyright © 2017 Daniel Roldan Chavez. All rights reserved.
//

import UIKit

class Viaje: NSObject{

    var thubnailImageName: String?
    var title: String?
    var subtitle: String?
    var price: String?
    var date: String?
    
    var channel: Channel?
}

class Channel: NSObject{
    var name: String?
}
