//
//  MenuBar.swift
//  Lifes Adventure
//
//  Created by Daniel Roldan Chavez on 18/02/17.
//  Copyright © 2017 Daniel Roldan Chavez. All rights reserved.
//

import UIKit

class MenuBar: UIView, UICollectionViewDataSource, UICollectionViewDelegate ,UICollectionViewDelegateFlowLayout{
    
    lazy var collectionView: UICollectionView = {
        let layout = UICollectionViewFlowLayout()
        let cv = UICollectionView(frame: .zero, collectionViewLayout: layout)
        cv.backgroundColor = UIColor.rgb(red: 0, green: 52, blue: 89, alpha: 1)
        cv.dataSource = self
        cv.delegate = self
        return cv
    }()
    
    let cellId = "cellId"
    let imageNames = ["viajes","perfil","like"]
    
    
    override init(frame: CGRect){
        super.init(frame: frame)
        
        collectionView.register(MenuCell.self, forCellWithReuseIdentifier: cellId)
        
        addSubview(collectionView)
        addConstrainsWithFormat(format:"H:|[v0]|", view: collectionView)
        addConstrainsWithFormat(format:"V:|[v0]|", view: collectionView)
        let indexPath = IndexPath(row: 0, section: 0)
        collectionView.selectItem(at: indexPath, animated: false, scrollPosition: UICollectionViewScrollPosition.left)
    
    }
    //Numero de opciones
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return 3
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: cellId, for: indexPath) as! MenuCell
        
        cell.imageView.image = UIImage(named: imageNames[indexPath.item])?.withRenderingMode(.alwaysTemplate)
        cell.tintColor = UIColor.rgb(red: 0, green: 23, blue: 31, alpha: 1)
        return cell
    }
    //tamaño de celda
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: frame.width/3, height: frame.height)
    }
    
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }
    
    required init?(coder aDecoder: NSCoder){
        fatalError("init(coder:) has not been implemented")
    }
    
    
}

class MenuCell: BaseCell{
    
    let imageView: UIImageView = {
        let iv = UIImageView()
        iv.image = UIImage(named: "perfil")?.withRenderingMode(.alwaysTemplate)
        iv.tintColor = UIColor.rgb(red: 0, green: 23, blue: 31, alpha: 1)
        return iv
    }()
    
    override var isHighlighted: Bool{
        didSet {
            imageView.tintColor = isHighlighted ? UIColor.white : UIColor.rgb(red: 0, green: 23, blue: 31, alpha: 1)
        }
    }

    override var isSelected: Bool{
        didSet {
            imageView.tintColor = isSelected ? UIColor.white : UIColor.rgb(red: 0, green: 23, blue: 31, alpha: 1)
        }
    }
    
    override func setupViews(){
        super.setupViews();
        addSubview(imageView)
        addConstrainsWithFormat(format: "H:[v0(22)]", view: imageView)
        addConstrainsWithFormat(format: "V:[v0(22)]", view: imageView)
        
        addConstraint(NSLayoutConstraint(item: imageView, attribute: .centerX, relatedBy: .equal, toItem: self, attribute: .centerX, multiplier: 1, constant: 0))
        addConstraint(NSLayoutConstraint(item: imageView, attribute: .centerY, relatedBy: .equal, toItem: self, attribute: .centerY, multiplier: 1, constant: 0))
    }
}
