//
//  ViajeCell.swift
//  Lifes Adventure
//
//  Created by Daniel Roldan Chavez on 18/02/17.
//  Copyright © 2017 Daniel Roldan Chavez. All rights reserved.
//

import UIKit

class BaseCell: UICollectionViewCell {
    override init(frame: CGRect){
        super.init(frame: frame)
        setupViews()
    }
    
    func setupViews(){
        
    }
    
    required init?(coder aDecoder: NSCoder){
        fatalError("init(coder:) has not been implemented")
    }
}

class ViajeCell: BaseCell {
    
    var viaje: Viaje?{
        didSet{
            titleLabel.text = viaje?.title
            setupThumbnailImage()
           
            subtitleLabel.text = viaje?.subtitle
            
            if let signo = viaje?.price{
                
         //       let numberFormatter = NumberFormatter()
          //      numberFormatter.numberStyle = .decimal
                
                let price = "$ \(signo) "
                priceLabel.text = price
            }
            
            dateLabel.text = viaje?.date
           
        }
    }
    func  setupThumbnailImage(){
        if let thumbnailImageUrl = viaje?.thubnailImageName{
           
            
            let urlComplete = "http://\(thumbnailImageUrl)"
            print(urlComplete)
            let url = NSURL(string: urlComplete)
            URLSession.shared.dataTask(with: url! as URL) { (data, response, error) in
                
                if error != nil{
                    print(error)
                    return
                }

                  self.thumbnailImageView.image = UIImage(data: data!)
       
                
              

            }.resume()
        }
    }
    
    let thumbnailImageView: UIImageView = {
        let imageView = UIImageView()
        imageView.image = UIImage(named: "ejemplo")
        imageView.backgroundColor = UIColor.white
        imageView.contentMode = .scaleAspectFill
        imageView.clipsToBounds = true
        return imageView
    }()
    
    let priceLabel: UILabel = {
        let label = UILabel()
        label.text = "$ 4,000.00"
        label.textColor = UIColor.white
        return label
    }()
    
    let dateLabel: UILabel = {
        let label = UILabel()
        label.text = "15 agos.2017"
        label.textColor = UIColor.white
        return label
    }()
    
    let titleLabel: UILabel = {
        let label = UILabel()
        label.text = "Viaja a Yucatan"
        label.textColor = UIColor.white
        label.font = label.font.withSize(30)
        label.backgroundColor = UIColor.rgb(red: 0, green: 0, blue: 0, alpha: 2/10)
        return label
    }()
    
    let subtitleLabel: UILabel = {
        let sublabel = UILabel()
        sublabel.text = "Conoce Merida"
        sublabel.textColor = UIColor.white
        sublabel.translatesAutoresizingMaskIntoConstraints = false
        sublabel.font = sublabel.font.withSize(20)
        sublabel.backgroundColor = UIColor.rgb(red: 0, green: 0, blue: 0, alpha: 2/10)
        return sublabel
    }()
    
    let separatorView: UIView = {
        let view = UIView()
        view.backgroundColor = UIColor(red: 230/255, green: 320/255, blue: 230/255, alpha: 1)
        return view
    }()
    
    let separatorViewText: UIView = {
        let view = UIView()
        view.backgroundColor = UIColor(red: 230/255, green: 320/255, blue: 230/255, alpha: 1)
        view.translatesAutoresizingMaskIntoConstraints = false
        return view
    }()
    
    override func setupViews(){
        addSubview(thumbnailImageView)
        addSubview(separatorView)
        addSubview(priceLabel)
        addSubview(titleLabel)
        addSubview(subtitleLabel)
        addSubview(separatorViewText)
        addSubview(dateLabel)
        
        
        addConstrainsWithFormat(format: "H:|-0-[v0]-0-|", view: thumbnailImageView)
        addConstrainsWithFormat(format: "H:|-16-[v0(90)]|", view: priceLabel)
        
        addConstrainsWithFormat(format: "H:|-255-[v0(120)]|", view: dateLabel)
        addConstrainsWithFormat(format: "V:|-205-[v0(40)]", view: dateLabel)
    
        addConstrainsWithFormat(format: "V:|-0-[v0(250)]-0-[v1(40)]-0-[v2(1)]|", view: thumbnailImageView,priceLabel,separatorView)
        addConstrainsWithFormat(format: "H:|[v0]|", view: separatorView)
        
        addConstrainsWithFormat(format: "V:|-125-[v0(2)]|", view: separatorViewText)
        addConstrainsWithFormat(format: "H:|-16-[v0]-16-|", view: separatorViewText)
        
        addConstrainsWithFormat(format: "H:[v0]", view: titleLabel)
        addConstrainsWithFormat(format: "V:|-75-[v0(50)]-125-|", view: titleLabel)

        addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .centerX, relatedBy: .equal, toItem: self, attribute: .centerX, multiplier: 1, constant: 0))
        addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .centerY, relatedBy: .equal, toItem: self, attribute: .centerY, multiplier: 1, constant: 0))
        
        
        addConstraint(NSLayoutConstraint(item: subtitleLabel, attribute: .centerX, relatedBy: .equal, toItem: self, attribute: .centerX, multiplier: 1, constant: 0))
        
        addConstraint(NSLayoutConstraint(item: separatorViewText, attribute: .centerX, relatedBy: .equal, toItem: titleLabel, attribute: .centerX, multiplier: 1, constant: 10))
        addConstraint(NSLayoutConstraint(item: separatorViewText, attribute: .centerY, relatedBy: .equal, toItem: titleLabel, attribute: .centerY, multiplier: 1, constant: 10))
        
        
      //  addConstraint(NSLayoutConstraint(item: separatorViewText, attribute: .top, relatedBy: .equal, toItem: titleLabel, attribute: .bottom, multiplier: 1, constant: 4))
        //title
        //Top Constrains
      //  addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .top, relatedBy: .equal, toItem: thumbnailImageView, attribute: .bottom, multiplier: 1, constant: 8))
        //Left Constrains
       // addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .left, relatedBy: .equal, toItem: priceLabel, attribute: .right, multiplier: 1, constant: 8))
        //Right Constrains
      //  addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .right, relatedBy: .equal, toItem: thumbnailImageView, attribute: .right, multiplier: 1, constant: 0))
        //heigh Constrains
      //  addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .height, relatedBy: .equal, toItem: self, attribute: .height, multiplier: 0, constant: 20))
        
        //Subtitle
        //Top Constrains
        
       // addConstraint(NSLayoutConstraint(item: titleLabel, attribute: .top, relatedBy: .equal, toItem: separatorViewText, attribute: .bottom, multiplier: 1, constant: 4))
     
       addConstraint(NSLayoutConstraint(item: subtitleLabel, attribute: .top, relatedBy: .equal, toItem: titleLabel, attribute: .bottom, multiplier: 1, constant: 4))
        
         // addConstraint(NSLayoutConstraint(item: separatorViewText, attribute: .top, relatedBy: .equal, toItem: subtitleLabel, attribute: .bottom, multiplier: 1, constant: 8))
        //Left Constrains
      //  addConstraint(NSLayoutConstraint(item: subtitleLabel, attribute: .left, relatedBy: .equal, toItem: priceLabel, attribute: .right, multiplier: 1, constant: 8))
        //Right Constrains
      //  addConstraint(NSLayoutConstraint(item: subtitleLabel, attribute: .right, relatedBy: .equal, toItem: thumbnailImageView, attribute: .right, multiplier: 1, constant: 0))
        //heigh Constrains
        addConstraint(NSLayoutConstraint(item: subtitleLabel, attribute: .height, relatedBy: .equal, toItem: self, attribute: .height, multiplier: 0, constant: 30))
        
    }
    

    
}

