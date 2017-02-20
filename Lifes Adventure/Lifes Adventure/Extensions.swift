//
//  Extensions.swift
//  Lifes Adventure
//
//  Created by Daniel Roldan Chavez on 18/02/17.
//  Copyright © 2017 Daniel Roldan Chavez. All rights reserved.
//

import UIKit

extension UIColor{
    static func rgb(red: CGFloat, green: CGFloat, blue: CGFloat, alpha: CGFloat) -> UIColor{
        return UIColor(red: red/255, green: green/255, blue: blue/255, alpha: alpha)
    }
}

//agregar Constrains
extension UIView{
    func addConstrainsWithFormat(format: String, view: UIView ...)
    {
        var viewsDictionary = [String:UIView]()
        for(index,view) in view.enumerated(){
            let key = "v\(index)"
            view.translatesAutoresizingMaskIntoConstraints = false
            viewsDictionary[key] = view
        }
        addConstraints(NSLayoutConstraint.constraints(withVisualFormat: format, options: NSLayoutFormatOptions(), metrics: nil, views: viewsDictionary))
}
}
